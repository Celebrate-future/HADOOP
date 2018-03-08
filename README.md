# HADOOP
Materiały do szkolenia: HADOOP Projektowanie rozwiązań Big Data z wykorzystaniem Apache Hadoop &amp; Family

# Ustawienie zmiennych systemowych

* HADOOP_HDFS_HOME - katalog użytkownika na HDFS'ie
* HADOOP_HDFS_USER - nazwa użytkownika na HDFS'ie
* HADOOP_DATA - lokalizacja danych testowych (ścieżka lokalna)
* HADOOP_PROJECT - lokalizacja projektu HADOOP (ścieżka lokalna)

Przykład:

```
export HADOOP_HDFS_HOME=/user/sages
export HADOOP_HDFS_USER=sages
export HADOOP_DATA=/home/sages/dane
export HADOOP_PROJECT=/home/sages/repository/HADOOP
```

# Ambari

http://sandbox.hortonworks.com:8080

# Adresy i porty

https://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.6.2/bk_reference/content/reference_chap2.html
https://hortonworks.com/tutorial/sandbox-port-forwarding-guide/section/1/

~~~
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "SSH"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "Ambari"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "NameNodeHttp"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "NameNodeHttps"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "NameNodeMetadata"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "DataNodeHttp"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "DataNodeHttps"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "DataNodeData"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "DataNodeDatas"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "DataNodeMetadata"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "SecondaryNameNodeHttp"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "ResourceManagerUI"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "JobHistoryUI"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "Zookeeper"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "HMaster"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "HMasterInfoWebUI"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "RegionServer"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "RegionServerInfo"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "SparkHistoryUI"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "Spark2HistoryUI"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "Oozie"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "Kafka"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 delete "KafkaAmbari"

VBoxManage showvminfo "Hortonworks Data Platform Sandbox 2.6" | grep Rule

VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "SSH,tcp,127.0.0.1,2222,,22"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "Ambari,tcp,127.0.0.1,8080,,8080"
#VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "NameNodeHttp,tcp,127.0.0.1,50070,,50070"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "NameNodeHttps,tcp,127.0.0.1,50470,,50470"
#VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "NameNodeMetadata,tcp,127.0.0.1,8020,,8020"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "DataNodeHttp,tcp,127.0.0.1,50075,,50075"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "DataNodeHttps,tcp,127.0.0.1,50475,,50475"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "DataNodeData,tcp,127.0.0.1,50010,,50010"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "DataNodeDatas,tcp,127.0.0.1,1019,,1019"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "DataNodeMetadata,tcp,127.0.0.1,50020,,50020"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "SecondaryNameNodeHttp,tcp,127.0.0.1,50090,,50090"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "ResourceManagerUI,tcp,127.0.0.1,8088,,8088"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "JobHistoryUI,tcp,127.0.0.1,19888,,19888"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "Zookeeper,tcp,127.0.0.1,2181,,2181"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "HMaster,tcp,127.0.0.1,16000,,16000"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "HMasterInfoWebUI,tcp,127.0.0.1,16010,,16010"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "RegionServer,tcp,127.0.0.1,16020,,16020"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "RegionServerInfo,tcp,127.0.0.1,16030,,16030"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "SparkHistoryUI,tcp,127.0.0.1,18080,,18080"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "Spark2HistoryUI,tcp,127.0.0.1,18081,,18081"
VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "Oozie,tcp,127.0.0.1,11000,,11000"
#VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "Kafka,tcp,127.0.0.1,9092,,9092"
#VBoxManage modifyvm "Hortonworks Data Platform Sandbox 2.6" --natpf1 "KafkaAmbari,tcp,127.0.0.1,6667,,6667"

VBoxManage showvminfo "Hortonworks Data Platform Sandbox 2.6" | grep Rule
~~~

~~~
VBoxManage startvm "Hortonworks Data Platform Sandbox 2.6"
VBoxManage startvm "Hortonworks Data Platform Sandbox 2.6" --type headless
~~~

# SSH

~~~
ssh root@localhost -p 2222
ssh root@localhost -L 8020:localhost:8020 -L 50070:localhost:50070 -p 2222
ssh root@localhost -L 8020:localhost:8020 -L 50070:localhost:50070 -L 2181:localhost:2181 -L 16000:localhost:16000 -L 16020:localhost:16020 -p 2222
ssh root@localhost -L 9092:localhost:9092 -L 9093:localhost:9093 -L 9094:localhost:9094 -p 2222
~~~

~~~
Host hsandbox
    Hostname localhost
    Port 2222
    User root
    LocalForward 8020 localhost:8020
    LocalForward 50070 localhost:50070
    LocalForward 9092 localhost:9092
    LocalForward 6667 localhost:6667
~~~

# SSHFS

~~~
mkdir /tmp/sages
sshfs sages@localhost:/home/sages /tmp/sages/ -p 2222 -o cache_timeout=80 -f -o allow_other -o no_remote_lock
~~~