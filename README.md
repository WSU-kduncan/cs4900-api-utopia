# OpenTrainer

The API repository for OpenTrainer.

## Setup

1. Grab the docker and SQL scripts from [cs4900-utopia](https://github.com/WSU-kduncan/cs4900-utopia/tree/main/DATABASE/Scripts) (e.g. `git clone https://github.com/WSU-kduncan/cs4900-utopia.git && cd cs4900-utopia/DATABASE/Scripts`)
2. Run docker (`docker compose up -d`)
3. Run the API service in the root of this repository (`./gradlew bootRun`)