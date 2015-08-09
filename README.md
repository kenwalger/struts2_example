#Jive Software

####Software Support Engineer Interview Test

#####Ken W. Alger

<kenalger@comcast.net>

---

######Configuration of MySQL Server
1. Run the contents of the `script.sql` query, either from the attached file or from the Script below, in MySQL administration.
2. This will create a database called `jive_ssei_test` and a table called `entries`.
3. The MySQL database has the default username of "**root**" and password or "**root**".

######Installation of WAR file
1. Stop Tomcat.
1. Copy `Jive_SSEI_Test_war.war` to the **TOMCAT_HOME/webapps** folder.
1. Start Tomcat.
  

---

_MySQL Script_

---

```sql
CREATE DATABASE IF NOT EXISTS jive_ssei_test
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS jive_ssei_test.entries (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  os          VARCHAR(30),
  osVersion   VARCHAR(30),
  notes       VARCHAR(150),
  created     TIMESTAMP DEFAULT NOW()
);
```
