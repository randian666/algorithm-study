package com.algorithm.study.demo.datastructure.linear;



/**
 * Created by liuxun on 2017/6/14.
 */
public class Test {
    public static void main(String[] args) {
//        MyArrayList<String> list=new MyArrayList<String>();
//        list.addElem(0,"hello2");
//        list.addElem(0,"hello1");
////        list.setElem(0,"hello3");
//        list.add("hello4");
//        list.del("hello4");
////        list.delElem(0);
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.getElem(i));
//        }
//        System.out.println(list.size());
//        List<String> list2=new ArrayList<String>();
//        list2.add("2");
//        list2.remove("2");
//
//        LinkedList<String> list3=new LinkedList<String>();
//        list3.add("a");
//        list3.add("b");
//        list3.add(1,"c");
//        list3.addFirst("d");
//        list3.addFirst("c");
//        list3.getLast();
//        for (int i=0;i<list3.size();i++){
//            System.out.println(list3.get(i));
//        }

//        MLinkList<String> linkList=new MLinkList<String>();
//        linkList.addFirst("A");
//        linkList.addFirst("B");
//        linkList.addFirst("C");

//        linkList.delete(3);
//        linkList.add("A");
//        linkList.add("B");
//        linkList.add("C");
//        linkList.add("D");
//        linkList.add(2,"D");
//        linkList.add("E");
//        linkList.delete(4);
//        linkList.set(2,"PPP");
//        linkList.delete("D");
//        linkList.clear();
//        System.out.println("已删除头结点："+linkList.deleteFirst());
//        for (int i=0;i<linkList.size();i++){
//            System.out.println(linkList.get(i));
//        }


//        TwoLinkList<String> twoLinkList=new TwoLinkList<String>();
//        twoLinkList.addFirst("A");
//        twoLinkList.addFirst("B");
//        twoLinkList.addFirst("C");
//        twoLinkList.addLast("D");
//        twoLinkList.add("E");
//        System.out.println("头元素："+twoLinkList.getFirst());
//        System.out.println("尾元素："+twoLinkList.getLast());
//        System.out.println("删除后的头元素："+twoLinkList.deleteFirst());
//        System.out.println("删除后的尾元素："+twoLinkList.deleteLast());
//        twoLinkList.set(0,"KKK");
//        for (int i=0;i<twoLinkList.size();i++){
//            System.out.println(twoLinkList.get(i));
//        }
//        System.out.println("头元素："+twoLinkList.getFirst());
//        System.out.println("尾元素："+twoLinkList.getLast());
//        ArrayStack<String> stack=new ArrayStack<String>();
//        stack.push("A1");
//        stack.push("A2");
//        stack.push("A3");
//        stack.push("A4");
//        stack.push("A5");
//        System.out.println("出栈元素："+stack.pop());
//        System.out.println("出栈元素："+stack.pop());
//        System.out.println("出栈元素："+stack.pop());
//        System.out.println("出栈元素："+stack.pop());
//        System.out.println("栈顶元素："+stack.peek());
//        System.out.println("出栈元素："+stack.pop());

//        LinkStack<String> linkStack=new LinkStack<String>();
//        linkStack.push("A");
//        linkStack.push("B");
//        linkStack.push("C");
//        System.out.println("栈顶元素为："+linkStack.peek());
//        System.out.println("出栈元素为："+linkStack.pop());
//        SqQueue sqQueue=new SqQueue(3);
        LinkQueue linkQueue=new LinkQueue(3);
        linkQueue.add("a");
        linkQueue.add("b");
        linkQueue.add("c");
        System.out.println("出队："+linkQueue.poll());
        System.out.println("出队："+linkQueue.poll());
        System.out.println("出队："+linkQueue.poll());
        linkQueue.add("d");
        System.out.println("出队："+linkQueue.poll());
//        linkQueue.poll();
//        linkQueue.poll();
        System.out.println(linkQueue.size());
//        Queue queue=new ArrayBlockingQueue(1);
//        queue.add("1");
//        queue.poll();
//        queue.peek();
//        Queue queue1=new LinkedBlockingQueue(1);
    }
    //斐波那契数列递归实现方式
    public static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
