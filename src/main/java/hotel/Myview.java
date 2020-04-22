package hotel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Myview_table")
public class Myview {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String name;
        private String userid;
        private String phone;
        private String date;
        private Long regId;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
        public Long getRegId() {
            return regId;
        }

        public void setRegId(Long regId) {
            this.regId = regId;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
