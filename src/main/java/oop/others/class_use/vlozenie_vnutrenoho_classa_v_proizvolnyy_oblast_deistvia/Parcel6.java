package Examples.OOP.Others.class_use.vlozenie_vnutrenoho_classa_v_proizvolnyy_oblast_deistvia;

// Vlozenii class v oblast deistvia.
public class Parcel6 {
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSplip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSplip();
        }
        // Zdes nevozmozno ispolzovat class TrackingSlip! Vne oblasti deistvia:
        //! TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }
}
