package week4.GLS;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "package")
public class PackageGLS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;
    @Column(name = "tracking_number", length = 50)
    private String trackingNumber;
    @Column(name = "sender_name", length = 50)
    private String senderName;
    @Column(name = "receiver_name", length = 50)
    private String receiverName;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @PrePersist
    public void preprsist() {
        this.lastUpdated = LocalDateTime.now();
    }

    public enum DeliveryStatus {
        PENDING, IN_TRANSIT, DELIVERED
    }

  /*  public PackageGLS(String trackingNumber, String senderName, String receiverName, DeliveryStatus deliveryStatus) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.deliveryStatus = deliveryStatus;
    }*/

}
   /* @Override
    public String toString() {
        return "PackageGLS{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}

*/
