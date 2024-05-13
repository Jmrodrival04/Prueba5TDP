package Construction;

public class ThemedServiceStrategy implements ServiceStrategy {
    @Override
    public void serve() {
        System.out.println("Thematic service with special decorations.");
    }
}