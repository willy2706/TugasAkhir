#!/bin/bash

FLUMEDIR=/home/hduser/apache-flume-1.6.0-bin
KAFKAHDFSCONF=$FLUMEDIR/flume

topics=(part supplier partsupp lineitem orders customer nation region)

for i in ${topics[@]};
do
	echo $i
	strtmp="$KAFKAHDFSCONF/kafkaHDFS$i.conf"
	echo $strtmp
	nohup $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file $strtmp --name $i -Dflume.root.logger=INFO,console &
done

# nohup bin/flume-ng agent --conf conf --conf-file flume/kafkaHDFSpart.conf --name kafkaHDFSpart -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSpart.conf --name kafkaHDFSpart -Dflume.root.logger=INFO,console; &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSsupplier.conf --name kafkaHDFSsupplier -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSpartsupp.conf --name kafkaHDFSpartsupp -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSlineitem.conf --name kafkaHDFSlineitem -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSorders.conf --name kafkaHDFSorders -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFScustomer.conf --name kafkaHDFScustomer -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSnation.conf --name kafkaHDFSnation -Dflume.root.logger=INFO,console &
# $FLUMEDIR/bin/flume-ng agent --conf conf --conf-file /home/hduser/apache-flume-1.6.0-bin/flume/kafkaHDFSregion.conf --name kafkaHDFSregion -Dflume.root.logger=INFO,console &