
Scenario 1: To run successful transaction:
(1)run JBoss
(2)run deploy.sh to deploy to JBoss
(3)run insertQ.sh to insert a random message into HornetQ queue
(4)run moveQueueToDB.sh to transfer queue to MySQL
(5)run displayDB.sh to show database records, a new record should be in the database
(6)check JBoss web console to see that there is no message in the queue

Scenario 2: To run unsuccessful transaction:
(1)comment in " throw new RuntimeException("xxxxx");" in DefaultStudentService.java
(2)follow Scenario 1
(3)check JBoss web console to see that the message in still in the queue
(4)there should be no record inserted into the database
