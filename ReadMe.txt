1. This process will be run continuously in order to check file in a folder.
2. In order to close process, press ctrl + c.
3. To make build, Please run following command "mvn clean install"
4. Path and max_limit configurable. You can find in property file name "config.properties".
  

Please find below following assumptions that I have made.

1. File will always contain one record and in order of given in document.

For example: date_time, server_id, cpu_usage, total_disk_space, used_disk_space, total_memory, used_memory, temperature

2. On this above assumption, getting value on this basis from file.

3. Property file path is hard coded. It is placed in constant file. File Name is "MonitorConstant".


Dependency:

You can find property file in zip file and placed it on F: folder if you have and run this build. If not please placed in

your local folder and change path in "MonitorConstant" file.