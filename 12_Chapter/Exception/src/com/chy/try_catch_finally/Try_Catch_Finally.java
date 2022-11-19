package com.chy.try_catch_finally;

public class Try_Catch_Finally {
    //try_catch_finally处理机制，finally可写可不写，语法是可以通过的
    //try必须要和一个配合使用，catch/finally，不能单独使用try，语法错误！！
    /*
        try{
            代码/可能有异常
        }catch(Exception e){
            1、捕获到异常
            2、当异常发生时
            3、Exception 对象 e，传递给catch
            4、得到异常对象后，程序员，自行处理
            5、注意：如果没有发生异常catch代码块不执行
        }finally{
            1、不管try代码块是否有异常发生，始终要执行finally
            2、所以通常将释放资源的代码，放在finally
        }
     */
}
