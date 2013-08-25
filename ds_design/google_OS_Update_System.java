/*google_OS_Update_System
google

Different Chrome OS users have different settings for update the OS. Google
Chrome OS group updates the system every week and even more frequently, every
day if any backdoor/0day threat.

How do we design system for that?
*/



/*
1. Create different user groups according to all kinds of user update settings.
   Users set update config to 'i want everything' will automatically get pathed
   every time a patch is available; For other users show a reminder window to
   them.
2. User-end poll update info from where update patches store or Chrome service
   send a notification every time there is a new patch available.
3. If the update patch is large, say hundereds of metabytes, try to send the
   file block by block with peer-to-peer. If the patch is small, say, couple
   of kilobytes, then FTP is fine.
*/
