package Construction;

public interface ServiceStrategy {
    void serve();
    class CasualServiceStrategy implements ServiceStrategy {
        @Override
        public void serve() {
            System.out.println("Casual service for fast food.");
        }
    }

    class ThemedServiceStrategy implements ServiceStrategy {
        @Override
        public void serve() {
            System.out.println("Thematic service with special decorations.");
        }
    }

    class FineDiningServiceStrategy implements ServiceStrategy {
        @Override
        public void serve() {
            System.out.println("Exquisite service with attention to detail.");
        }
    }
}
