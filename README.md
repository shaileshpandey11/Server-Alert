# Server-Alert
This process will be run continuously in order to check file in a folder.
In order to close process, press **ctrl + c**.
To make build, Please run following command "**mvn clean install**"
Path and max_limit configurable. You can find in property file name "**config.properties**".
  

## Assumptions

File will always contain one record and in order of given in document.

For example: date_time, server_id, cpu_usage, total_disk_space, used_disk_space, total_memory, used_memory, temperature

On this above assumption, getting value on this basis from file.

Property file path is hard coded. It is placed in constant file. File Name is "**MonitorConstant**".


## Dependency

You can find property file in zip file and placed it on F: folder if you have and run this build. If not please placed in

your local folder and change path in "**MonitorConstant**" file.
