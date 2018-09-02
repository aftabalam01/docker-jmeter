# build this docker to send jmeter metrics to SQS. which can then be push to timeseries DB like influxDB( https://blog.outlyer.com/top10-open-source-time-series-databases)
# OR data can be saved in S3 or aurora DB and we can use tableau desktop as well to view live data
#### how to use this docker ####
# not code change and just need to run docker with existing script?
# docker build -t aftabalam01/myapp-jmeter-4.0 -f DockerFile_Jmeter_myapp
# docker pull aftabalam01/tabid-jmeter-4.0:latest
# option1 - run in interactive mode
# docker run --rm -it -e AWS_REGION=US-WEST-2 aftabalam01/myapp-jmeter-4.0:latest /bin/bash
#./sample_launch.sh <jmeter args>
# OR 
# docker run --rm -it -v c:\users\<usename>\.aws\:/root/.aws/ -e AWS_REGION=us-west-2 tabid-jmeter-4.0:latest ./sample_launch.sh <jmeter args>
# if this docker is run on aws ecs or EC2 with correct IAM, we do not have to pass credentials