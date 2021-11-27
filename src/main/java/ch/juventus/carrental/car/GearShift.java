package ch.juventus.carrental.car;

public enum GearShift {
    MANUAL{
        @Override
        public String toString() {return "manual";}
    };
    AUTOMATIC{
        @Override
                public String toString() {return "automatic";}};
}
