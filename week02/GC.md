# GC

GC总结分析：使用参数java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g - GCLogAnalysis

1. UseSerialGC使用串行化GC，young区回收为defNew，old区回收为Tenured，两者回收时间相近，因为使用的是单线程回收，年轻代和老年代串行执行，执行效率较低，并且堆内存越大，执行效率越低

2. UseParallelGC使用并行GC，young区回收为PSYoungGen,old区回收为ParOldGen，创建对象多，吞吐量更大，年轻代和老年代可以并行执行，年轻代和老年代都会导致GC暂停，堆内存的增加可以使得GC次数变少，但是每次GC的时间将会变长

3. UseConcMarkSweepGC:young区为ParNew(串行化垃圾回收器改进变成多线程)，old区阶段

   1. CMS Initial Mark初始化标记，标记跟对象和跟对象的可达对象，用时很快，GC暂停

   2. concurrent-start，并发阶段

   3. concurrent-mark，并发标记

   4. concurrent-preclean-start

   5. concurrent-preclean并发预清理

   6. concurrent-abortable-preclean-start可取消的并发预清理

   7. CMS Final Remark最终标记,GC暂停

   8. concurrent-sweep-start

   9. concurrent-sweep并发清理

   10. concurrent-reset-start

   11. concurrent-reset并发重置，准备下一阶段的CMS GC

       GC暂停时间短，不使用全部的CPU线程，老年代的回收相较于并行GC更短