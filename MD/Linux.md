**查找Cpu过高查找方法**
>第一步，找到占用cpu最高的一个线程
方法一：top -p [pid]
方法二：ps -mo spid,lwp,stime,time,%cpu -p [pid]
方法三：直接top,然后shift+h
>第二步，将其转化成16进制。假使我们得到的线程号为n，接下来将它转成16进制，记为spid
方法一：echo "obase=64;n"|bc
方法二：printf 0x%x n
>下一步，执行jstack -l pid| grep spid -A 100 打印后面100行分析问题
或者  Jstack -l PID >> 123.txt输出到文件后然后根据spid搜索定位问题