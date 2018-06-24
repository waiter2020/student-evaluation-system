package UPCmvc.common.dto;

/**
 * Created by lylllcc on 2017/5/14.
 */
public class VerifyUserInfo {
    public String status;
    public RealInfo info;

    public class RealInfo {
        public int yb_userid;
        public String yb_realname;
        public String yb_schoolid;
        public String yb_schoolname;
        public String yb_studentid;
        public String yb_examid;
        public String yb_admissionid;
        public String yb_employid;
        public String code;
        public String msgCN;
        public String msgEN;
    }
}
