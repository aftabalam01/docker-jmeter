#!/bin/bash

set -e
freeMem=`awk '/MemFree/ { print int($2/1024) }' /proc/meminfo`
s=$(($freeMem/10*8))
x=$(($freeMem/10*8))
n=$(($freeMem/10*2))
export JVM_ARGS="-Xmn${n}m -Xms${s}m -Xmx${x}m"

echo "START Running Jmeter on `date`"
echo "JVM_ARGS=${JVM_ARGS}"
echo "jmeter args=$@"
cmd_args=$@
if [ $# -eq 0 ]
  then
    echo "No arguments supplied. Opting for default options"
    echo "cmd_args=-n -JEnv=vNext -JTAB_ID_SERVER=id.vnext.tabint.net -JLOGIN_THREAD=50 -JREGISTER_THREAD=20 -JDURATION=900 -t ./scripts/jmeter/TabID_API3.1_Perf_v0.1.jmx"
    cmd_args="-n -JEnv=vNext -JTAB_ID_SERVER=id.vnext.tabint.net -JLOGIN_THREAD=50 -JREGISTER_THREAD=20 -JDURATION=900 -t ./scripts/jmeter/TabID_API3.1_Perf_v0.1.jmx"
fi

# Keep entrypoint simple: we must pass the standard JMeter arguments
jmeter ${cmd_args}
echo "END Running Jmeter on `date`"