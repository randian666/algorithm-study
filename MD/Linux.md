### 用一行命令输出正在运行的java进程
jps 用法 参数说明<br>
     -q：只输出进程 ID
     -m：输出传入 main 方法的参数
     -l：输出完全的包名，应用主类名，jar的完全路径名
     -v：输出jvm参数
     -V：输出通过flag文件传递到JVM中的参数
     
### 查找Cpu过高查找方法
- 第一步，找到占用cpu最高的一个线程
方法一：top -p [pid]
方法二：ps -mo spid,lwp,stime,time,%cpu -p [pid]
方法三：直接top,然后shift+h
- 第二步，将其转化成16进制。假使我们得到的线程号为n，接下来将它转成16进制，记为spid
方法一：echo "obase=64;n"|bc
方法二：printf 0x%x n
- 下一步，执行jstack -l pid| grep spid -A 100 打印后面100行分析问题
或者  Jstack -l PID >> 123.txt输出到文件后(spid等于文件中的nid)然后根据spid搜索定位问题

### 用一行命令查看文件的最后五行。
可以使用head（查看前几行）、tail（查看末尾几行）两个命令。


### [top 命令之后有哪些内容，有什么作用。](https://www.cnblogs.com/lxyit/p/8946741.html)




