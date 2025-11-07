public class SessionBlocker implements Observer {
    private final Session session;
    public SessionBlocker(Session session) { this.session = session; }

    @Override
    public void update(BaggingArea subject) {
        if (subject.hasDiscrepancy()) session.blockSession();
        else session.unblockSession();
    }
}
