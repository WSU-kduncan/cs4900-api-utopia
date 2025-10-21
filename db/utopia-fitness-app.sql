-- ===========================================
-- Database Initialization Script: Utopia DB
-- ===========================================

-- Drop tables
DROP TABLE IF EXISTS Routine_Exercise CASCADE;
DROP TABLE IF EXISTS Session CASCADE;
DROP TABLE IF EXISTS Exercise CASCADE;
DROP TABLE IF EXISTS Routine CASCADE;
DROP TABLE IF EXISTS Client CASCADE;
DROP TABLE IF EXISTS Trainer CASCADE;

-- ==========================================
-- Trainer Table
-- ==========================================
CREATE TABLE Trainer (
  trainer_id     INTEGER       NOT NULL AUTO_INCREMENT   COMMENT 'PK for Trainer',
  trainer_name   VARCHAR(50)   NOT NULL                  COMMENT 'Name',
  trainer_email  VARCHAR(50)   NOT NULL UNIQUE           COMMENT 'Email',
  password_hash  VARCHAR(255)  NOT NULL                  COMMENT 'Password',

  PRIMARY KEY (trainer_id)
  )
  COMMENT 'Trainer'
  ;

-- Sample Trainers
INSERT INTO Trainer (trainer_name, trainer_email, password_hash) VALUES
  ('Arnold Coleman', 'arnold@awesome.com', 'abcdefg'),
  ('Charles Odderson', 'codderson@awesome.com', '123456'),
  ('Melissa Moore', 'imsomoored@awesome.com', 'thisismypassword');

-- ==========================================
-- Client Table
-- ==========================================
CREATE TABLE Client (
  client_id      INTEGER      NOT NULL AUTO_INCREMENT  COMMENT 'PK for Client',
  client_name    VARCHAR(50)  NOT NULL                 COMMENT 'Name',
  client_email   VARCHAR(50)  NOT NULL UNIQUE          COMMENT 'Email',
  password_hash  VARCHAR(255) NOT NULL                 COMMENT 'Password',
  trainer_id     INTEGER      NOT NULL                 COMMENT 'FK to Trainer',

  PRIMARY KEY (client_id),
  FOREIGN KEY (trainer_id) REFERENCES Trainer(trainer_id)
  )
  COMMENT 'Client'
  ;

-- Sample Clients
SET @arnold  = (SELECT trainer_id FROM Trainer WHERE trainer_email = 'arnold@awesome.com');
SET @charles = (SELECT trainer_id FROM Trainer WHERE trainer_email = 'codderson@awesome.com');
SET @melissa = (SELECT trainer_id FROM Trainer WHERE trainer_email = 'imsomoored@awesome.com');

INSERT INTO Client (client_name, client_email, password_hash, trainer_id) VALUES
  ('John Jones', 'john@awesome.com', 'pw123', @arnold),
  ('Curtis Focker', 'curtis@awesome.com', 'pw456', @charles),
  ('Kelly Walters', 'kelly@awesome.com', 'pw789', @melissa);

-- ==========================================
-- Routine Table
-- ==========================================
CREATE TABLE Routine (
  routine_id     INTEGER       NOT NULL  AUTO_INCREMENT  COMMENT 'PK for Routine',
  routine_name   VARCHAR(50)   NOT NULL  UNIQUE          COMMENT 'Name',
  description    TEXT                                    COMMENT 'Description',

  PRIMARY KEY (routine_id)
)
COMMENT 'Routine'
;

-- Sample Routines
INSERT INTO Routine (routine_name, description) VALUES
  ('Full Body Strength', 'A balanced routine focusing on all major muscle groups.'),
  ('Cardio Endurance', 'Interval running and cycling for stamina.'),
  ('Core Builder', 'Focus on abdominal and lower back strength.');

-- ==========================================
-- Exercise Table
-- ==========================================
CREATE TABLE Exercise (
  exercise_id     INTEGER      NOT NULL  AUTO_INCREMENT  COMMENT 'PK for Exercise',
  exercise_name   VARCHAR(50)  NOT NULL  UNIQUE          COMMENT 'Name',
  note            TEXT                                   COMMENT 'Note',
  duration        TIME         DEFAULT   '00:00:00'      COMMENT 'Duration',
  reps            INTEGER                                COMMENT 'Reps',

  PRIMARY KEY (exercise_id)
)
COMMENT 'Exercise'
;

-- Sample Exercises
INSERT INTO Exercise (exercise_name, note, duration, reps) VALUES
  ('Push-ups', 'Keep your back straight.', '00:00:00', 15),
  ('Squats', 'Focus on form and depth.', '00:00:00', 20),
  ('Plank', 'Hold position without arching back.', '00:01:00', NULL),
  ('Jump Rope', 'Maintain steady rhythm.', '00:05:00', NULL);

-- ==========================================
-- Routine_Exercise (Many-to-Many)
-- ==========================================
CREATE TABLE Routine_Exercise (
  routine_id    INTEGER  NOT NULL  COMMENT 'FK to Routine',
  exercise_id   INTEGER  NOT NULL  COMMENT 'FK to Exercise',

  FOREIGN KEY (routine_id)  REFERENCES Routine(routine_id),
  FOREIGN KEY (exercise_id) REFERENCES Exercise(exercise_id),
  PRIMARY KEY (routine_id, exercise_id)
)
COMMENT 'Routine_Exercise'
;

-- Sample Relationships
INSERT INTO Routine_Exercise (routine_id, exercise_id) VALUES
  (1, 1),
  (1, 2),
  (2, 4),
  (3, 3);

-- ==========================================
-- Session Table
-- ==========================================
CREATE TABLE Session (
  session_id    INTEGER      NOT NULL  AUTO_INCREMENT              COMMENT 'PK for Session',
  client_id     INTEGER      NOT NULL                              COMMENT 'FK to Client',
  trainer_id    INTEGER      NOT NULL                              COMMENT 'FK to Trainer',
  routine_id    INTEGER      NOT NULL                              COMMENT 'FK to Routine',
  session_date  DATETIME     NOT NULL  DEFAULT CURRENT_TIMESTAMP   COMMENT 'Date and Time'
  note          TEXT                                               COMMENT 'Note',
  duration      TIME         DEFAULT   '00:00:00'                  COMMENT 'Duration',

  PRIMARY KEY (session_id),
  FOREIGN KEY (client_id)  REFERENCES Client(client_id),
  FOREIGN KEY (trainer_id) REFERENCES Trainer(trainer_id),
  FOREIGN KEY (routine_id) REFERENCES Routine(routine_id)
)
COMMENT 'Session'
;

-- Sample Sessions

-- Trainers
SET @arnold  = (SELECT trainer_id FROM Trainer WHERE trainer_email = 'arnold@awesome.com');
SET @melissa = (SELECT trainer_id FROM Trainer WHERE trainer_email = 'imsomoored@awesome.com');

-- Clients
SET @john  = (SELECT client_id FROM Client WHERE client_email = 'john@awesome.com');
SET @kelly = (SELECT client_id FROM Client WHERE client_email = 'kelly@awesome.com');

INSERT INTO Session (client_id, trainer_id, routine_id, session_date, note, duration) VALUES
  (@john, @arnold, 1, '2025-10-10 09:00:00', 'Focus on form and endurance.', '00:45:00'),
  (@kelly, @melissa, 2, '2025-10-11 14:00:00', 'Keep heart rate above 140 bpm.', '00:30:00');