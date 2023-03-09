package sec03.helper;


import course_util.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        var name = Util.faker().name().fullName();
        var thread = Thread.currentThread().getName();
        this.fluxSink.next(thread + " : " + name);
    }

    @Override
    public Consumer<FluxSink<String>> andThen(Consumer<? super FluxSink<String>> after) {
        return Consumer.super.andThen(after);
    }
}
