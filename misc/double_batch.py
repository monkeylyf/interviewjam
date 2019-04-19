"""
Given a list of use_id [int] and list[user_action], retrieve the information
from a database by user_id and correlate list[user_action] and write back to
the database in another table.
Normally, people do:
for user_id, user_actions in user_actions_by_id:
    user_info = connection.get(user_id)
    correlated = correlate(user_info, user_actions)
    for record in correlated:
        connection.write(record)

Which read records from database one by one and write correlated records one by
one.
1. For most of morden database, batch get/write is way more faster than a single
get/write. Why?
2. Try optimize the code above so read from database in batches. Assuming that
the read batch size is given as a constant.
3. Try optimize the code above so both read from database and write to database
is batches. Assuming that the write batch size is given as a constant.
4. How to tune read/write batch size?

connection.get(user_ids) that takes a list of user IDs is given.
connection.write(records) that takes a list of recrods is given.
"""

READ_BATCH_SIZE = 500
WRITE_BATCH_SIZE = 500

class BatchRead(object):

    def __init__(self, connection, logger):
        self.connection = connection
        self.logger = logger

    def batch_read(user_actions_by_id):
        batch_user_ids = []
        batch_user_actions = []
        count = 1
        for user_id, user_actions in user_actions_by_id:
            batch_user_ids.append(user_id)
            if len(batch_user_ids) < READ_BATCH_SIZE:
                continue
            self.logger.info("Batch #%s..." % count)
            batch_user_info = self.connection.get(batch_user_ids)
            for i, user_info in enumerate(batch_user_info):
                for record in correlate(user_info, batch_user_actions[i])
                    self.connection.write(record)
            batch_user_ids = []
            batch_user_actions = []
            count += 1
        # Left-over batch.
        if batch_user_ids:
            self.logger.info("Left-over batch #%s..." % count)
            batch_user_info = self.connection.get(batch_user_ids)
            for i, user_info in enumerate(batch_user_info):
                for record in correlate(user_info, batch_user_actions[i])
                    self.connection.write(record)


class BatchReadAndWrite(object):

    def __init__(self, connection):
        self.connection = connection
        self.logger = logger

    def batch_read_write(user_actions_by_id):
        batch_user_ids = []
        batch_user_actions = []
        batch_records = []
        read_batch_count = 1
        write_batch_count = 1
        for user_id, user_actions in user_actions_by_id:
            batch_user_ids.append(user_id)
            if len(batch_user_ids) < READ_BATCH_SIZE:
                continue
            self.logger.info("Batch #%d..." % read_batch_count)
            batch_user_info = self.connection.get(batch_user_ids)
            for i, user_info in enumerate(batch_user_info):
                for record in correlate(user_info, batch_user_actions[i])
                    batch_records.append(record)
                    if len(batch_records) < WRITE_BATCH_SIZE:
                        continue
                    self.logger.info("Write batch #%d..." % write_batch_count)
                    self.connection.write(batch_records)
                    batch_records = []
                    write_batch_count += 1
            batch_user_ids = []
            batch_user_actions = []
            read_batch_count += 1
        # Left-over batch.
        if batch_user_ids:
            self.logger.info("Left-over batch #%s..." % read_batch_count)
            batch_user_info = self.connection.get(batch_user_ids)
            for i, user_info in enumerate(batch_user_info):
                for record in correlate(user_info, batch_user_actions[i])
                    batch_records.append(record)
                    if len(batch_records) < WRITE_BATCH_SIZE:
                        continue
                    self.logger.info("Write batch #%d..." % write_batch_count)
                    self.connection.write(batch_records)
                    batch_records = []
                    write_batch_count += 1
        if batch_records:
            self.logger.info("Left-over write batch #%d..." % write_batch_count)
            self.connection.write(batch_records)
