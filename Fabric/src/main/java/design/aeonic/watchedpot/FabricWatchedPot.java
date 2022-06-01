package design.aeonic.watchedpot;

public class FabricWatchedPot {

    public void initializeCommon() {
        WatchedPot.init();
    }

    public void initializeClient() {
        WatchedPot.clientInit(Runnable::run);
    }

}
