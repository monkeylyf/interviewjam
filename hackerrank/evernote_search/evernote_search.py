"""hackerrank_Evernote_Search.py

https://www.hackerrank.com/contests/evernote-coding-challenge/challenges/evernote-search
"""

from xml.etree import ElementTree as ET


class EvernoteSearch(object):

    """Evernote search class."""

    #TODO:
    # 1. Code cleanup. Especially the search_by_* part.
    # 2. WeakRefDictionary might be handy for deindexing
    # 3. Prefix tree might be handy but, token removal is tricky.

    def __init__(self):
        """Initializer."""
        self._notes = {}
        self._indice = {}

        # Setup function mapping.
        self._command_func_map = {Constants.CREATE : self._create,
                                  Constants.UPDATE : self._update,
                                  Constants.DELETE : self._delete,
                                  Constants.SEARCH : self._search, }
        self._search_func_map  = {Constants.CONTENT: self._search_by_content,
                                  Constants.TAG    : self._search_by_tag,
                                  Constants.CREATED: self._search_by_time, }

    def run(self):
        """Scan input for supported command and note/search content."""
        command, content = None, []
        while 1:
            try:
                line = raw_input()
                if line in self._command_func_map:
                    # Execute previous command.
                    if command:
                        self._command_func_map[command](content)
                    # New command.
                    command, content = line, []
                else:
                    content.append(line)
            except EOFError:
                break

        if command:
            # Execute last command.
            self._command_func_map[command](content)

    def filter_illegal_sign(self, content):
        """Dirty hack to avoid xml invalid character error.

        xml is, probably, the only built-in choice. it's easy to parse the
        xml-formatted notes but it gave me headaches.
        """
        if '&' in content:
            content = content.replace('&', 'and')

        return content

    def _parse_xml(self, content):
        """Parse contents in str into xml objects."""
        content = Constants.NEWLINE.join(content)
        root = ET.fromstring(self.filter_illegal_sign(content))

        note = {}
        guid = None

        for child in root:
            if child.tag == 'guid':
                guid = child.text
            elif child.tag == Constants.TAG:
                # Zero or more tag elements indicate the names of Tags assigned to the Note.
                try:
                    note[child.tag].add(child.text)
                except KeyError:
                    note[child.tag] = set((child.text, ))
            else:
                # Other tag should be unique.
                note[child.tag] = child.text

        return (guid, note)

    def _tokenize(self, text):
        """Tokenizer text."""
        tokens = []
        chars = []

        for char in text:
            if char.isalpha() or char.isdigit() or char == '\'':
                chars.append(char)
            elif chars:
                tokens.append(''.join(chars).lower())
                chars = []
            else:
                pass

        return tokens

    def _index(self, content, guid):
        """Add reverse index."""
        for token in self._tokenize(content):
            try:
                self._indice[token].add(guid)
            except KeyError:
                self._indice[token] = set((guid, ))

    def _deindex(self, content, guid):
        """Remove reverse index."""
        for token in self._tokenize(content):
            try:
                self._indice[token].remove(guid)
                if not self._indice[token]:
                    del self._indice[token]
            except KeyError:
                # Not necessarily inconstistant, it's possible that content
                # contains one token multiple times.
                pass

    def _create(self, content):
        """Create a note and index it."""
        (guid, note) = self._parse_xml(content)
        self._notes[guid] = note
        self._index(note[Constants.CONTENT], guid)

    def _update(self, content):
        """Update a note by deleting/deindexing previous version."""
        (guid, note) = self._parse_xml(content)
        obsolete_note = self._notes.get(guid, None)

        if not obsolete_note:
            raise KeyError("Updating non-existing guid", guid)

        self._deindex(obsolete_note[Constants.CONTENT], guid)
        self._index(note[Constants.CONTENT], guid)
        self._notes[guid] = note

    def _delete(self, guid):
        """Delete/deindex the note."""
        guid = guid[0]
        note = self._notes.pop(guid, None)
        if not note:
            raise ValueError('Invalid guid', guid)
        self._deindex(note[Constants.CONTENT], guid)

    def _search(self, keywords):
        """Search by content/tag/created time."""
        def parse_keywords(keywords):
            """"""
            keywords = keywords.split()
            parsed_keywords = []

            for keyword in keywords:
                if keyword.startswith('tag:'):
                    parsed_keywords.append((Constants.TAG, keyword[4:]))
                elif keyword.startswith('created:'):
                    parsed_keywords.append(('created', keyword[8:]))
                else:
                    parsed_keywords.append(('content', keyword))

            return parsed_keywords

        keywords = keywords[0]
        list_of_guids = []
        for typ, keyword in parse_keywords(keywords):
            list_of_guids.append(set(self._search_func_map[typ](keyword)))

        commond = set.intersection(*list_of_guids)
        print self._output_by_time(commond)

    def _output_by_time(self, guids):
        """Return guids in created time order."""
        # Construct tuple (created_time, guid)
        guid_and_created = [(self._notes[guid][Constants.CREATED], guid) for guid in guids]
        # Sort by created_tim:
        guid_and_created.sort()

        # Return list of sorted guids.
        return Constants.COMMA.join((item[1] for item in guid_and_created))

    def _search_by_content(self, keywords):
        """"""
        keywords = set(keywords.split())
        hits = [set()] * len(keywords)

        for i, keyword in enumerate(keywords):
            for token, guid_set in self._indice.iteritems():
                if self._match(keyword, token):
                    hits[i] = hits[i] | guid_set

        return reduce(lambda acc, x: acc & x, hits, hits[0])

    def _match(self, keyword, token):
        """"""
        if keyword.endswith(Constants.ASTERISK):
            return token.startswith(keyword[:-1])
        else:
            return keyword == token

    def _search_by_tag(self, keywords):
        """"""
        keywords = set(keywords.split())
        res = []

        for guid, note in self._notes.iteritems():
            try:
                if self._keyword_hit(keywords, note):
                    res.append(guid)
            except KeyError:
                # This note has no tags.
                pass

        return res

    def _keyword_hit(self, keywords, note):
        """"""
        hits = [False] * len(keywords)

        for i, keyword in enumerate(keywords):
            # Created time search.
            if keyword.startswith(Constants.CREATED):
                prefix = '-'.join((item for item in self._parse_time_str(keyword[8:]) if item))
                hits[i] = note[Constants.CREATED] > prefix
            # Prefix match.
            elif keyword.endswith(Constants.ASTERISK):
                prefix = keyword[:-1]
                for item in note[Constants.TAG]:
                    if item.startswith(prefix):
                        hits[i] = True
                        break
            # Exact keyword match.
            else:
                hits[i] = keyword in note[Constants.TAG]

        return all(hits)

    def _search_by_time(self, keyword):
        """"""
        prefix = Constants.HYPHEN.join((item for item in self._parse_time_str(keyword) if item))
        res = []

        for guid, note in self._notes.iteritems():
            if note[Constants.CREATED][:len(prefix)] > prefix:
                res.append(guid)

        return res

    def _parse_time_str(self, keyword):
        """"""
        year = keyword[:4] if len(keyword) >= 4 else None
        month = keyword[4:6] if len(keyword) >= 6 else None
        day = keyword[6:8] if len(keyword) >= 8 else None

        return (year, month, day)


class Constants(object):

    """Class to hold static constants."""

    # Commands.
    CREATE  = 'CREATE'
    SEARCH  = 'SEARCH'
    DELETE  = 'DELETE'
    UPDATE  = 'UPDATE'

    # keys.
    CREATED  = 'created'
    CONTENT  = 'content'
    GUID     = 'guid'
    TAG      = 'tag'

    # Punctuation.
    COMMA    = ','
    COLON    = ':'
    HYPHEN   = '-'
    ASTERISK = '*'
    NEWLINE  = '\n'


def main():
    """"""
    EvernoteSearch().run()


if __name__ == '__main__':
    main()
