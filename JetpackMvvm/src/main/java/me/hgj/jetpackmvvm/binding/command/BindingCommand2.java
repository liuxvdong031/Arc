package me.hgj.jetpackmvvm.binding.command;


/**
 * About : kelin的ReplyCommand
 * 执行的命令回调, 用于ViewModel与xml之间的数据绑定
 */
public class BindingCommand2<T> {

    private BindingConsumer<T> consumer;


    public BindingCommand2(BindingConsumer<T> execute) {
        this.consumer = execute;
    }


    public void execute(T parameter) {
        if (consumer != null) {
            consumer.call(parameter);
        }
    }


}
