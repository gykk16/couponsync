package kr.co.couponsample.coupon_sync.test;

import kr.co.couponsample.common_tools.builder.CouponBuilder;
import kr.co.couponsample.common_tools.CouponConstants;
import kr.co.couponsample.coupon_sync.converter.CouponConverter;
import kr.co.couponsample.coupon_sync.service.CouponIfService;
import kr.co.couponsample.coupon_sync.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public class CouponSyncTest {

    /* TEST SERVER */
    private final String SERVICE_MODE = "TEST";

    /* PROD SERVER */
    // private final String SERVICE_MODE = "PROD";

    private final String HOST_TYPE = "DEFAULT";


    private final String E_ID    = "";
    private final String M_ID    = "";
    private final String T_ID    = "";
    private final String G_ID    = "";
    private final String RMOBILE = "";
    private final String OMOBILE = "";
    private final String O_CNT   = "";
    private final String TM      = "";
    private final String CM      = "";
    private final String E_DAYS  = "";


    public static void main(String[] args) {
        CouponSyncTest couponSyncSample = new CouponSyncTest();


        couponSyncSample.couponSend();
        couponSyncSample.couponDetail();
        couponSyncSample.couponExchangeDays();
        couponSyncSample.couponCancel();

    }

    /**
     * ISSUE
     */
    public void couponSend() {
        try {
            CouponIfService service = CouponBuilder.getInstance().getServiceInstance(SERVICE_MODE, HOST_TYPE, CouponIfService.class);


            Call<String> call = service.couponSend(E_ID, M_ID, G_ID, O_CNT, "", OMOBILE, RMOBILE, T_ID, TM, CM);

            log.info("=============================== Request Info ===============================");
            log.info(call.request().toString());
            log.info("============================================================================");

            Response<String> response = call.execute();

            if (response.isSuccessful()) { // Http Status Code == 200~300
                CouponSendVO couponSendVO = CouponConverter.stringToCouponSend(response.body());

                if (StringUtils.equals(couponSendVO.getResultCode(), CouponConstants.ResultCode.SUCCESS_CODE)) { // Success
                    log.info("==> {}", couponSendVO.toString());
                } else { // Error
                    log.error("Error - ResultCode: {}, ResultMsg: {}", couponSendVO.getResultCode(), couponSendVO.getResultMsg());
                }
            } else { // Http Status Code != 200~300
                log.error("Http Status Error: {}", response.code());
            }
        } catch (Exception e) {
            log.error(e.getCause() == null ? e.toString() : e.getCause().toString());
        }
    }

    /**
     * RESEND : sms
     */
    public void couponReSend() {
        try {
            CouponIfService service = CouponBuilder.getInstance().getServiceInstance(SERVICE_MODE, HOST_TYPE, CouponIfService.class);


            Call<String> call = service.couponReSend(E_ID, M_ID, T_ID);

            log.info("=============================== Request Info ===============================");
            log.info(call.request().toString());
            log.info("============================================================================");

            Response<String> response = call.execute();

            if (response.isSuccessful()) { // Http Status Code == 200~300
                CouponReSendVO couponReSendVO = CouponConverter.stringToCouponReSend(response.body());

                if (StringUtils.equals(couponReSendVO.getResultCode(), CouponConstants.ResultCode.SUCCESS_CODE)) { // Success
                    log.info("==> {}", couponReSendVO.toString());
                } else { // Error
                    log.error("Error - ResultCode: {}, ResultMsg: {}", couponReSendVO.getResultCode(), couponReSendVO.getResultMsg());
                }
            } else { // Http Status Code != 200~300
                log.error("Http Status Error: {}", response.code());
            }
        } catch (Exception e) {
            log.error(e.getCause() == null ? e.toString() : e.getCause().toString());
        }
    }

    /**
     * CANCEL
     */
    public void couponCancel() {
        try {
            CouponIfService service = CouponBuilder.getInstance().getServiceInstance(SERVICE_MODE, HOST_TYPE, CouponIfService.class);


            Call<String> call = service.couponCancel(E_ID, M_ID, T_ID);

            log.info("=============================== Request Info ===============================");
            log.info(call.request().toString());
            log.info("============================================================================");

            Response<String> response = call.execute();

            if (response.isSuccessful()) { // Http Status Code == 200~300
                CouponCancelVO couponCancelVO = CouponConverter.stringToCouponCancel(response.body());

                if (StringUtils.equals(couponCancelVO.getResultCode(), CouponConstants.ResultCode.SUCCESS_CODE)) { // Success
                    log.info("==> {}", couponCancelVO.toString());
                } else { // Error
                    log.error("Error - ResultCode: {}, ResultMsg: {}", couponCancelVO.getResultCode(), couponCancelVO.getResultMsg());
                }
            } else { // Http Status Code != 200~300
                log.error("Http Status Error: {}", response.code());
            }
        } catch (Exception e) {
            log.error(e.getCause() == null ? e.toString() : e.getCause().toString());
        }
    }

    /**
     * DETAIL
     */
    public void couponDetail() {
        try {
            CouponIfService service = CouponBuilder.getInstance().getServiceInstance(SERVICE_MODE, HOST_TYPE, CouponIfService.class);


            Call<String> call = service.couponDetail(E_ID, M_ID, T_ID);

            log.info("=============================== Request Info ===============================");
            log.info(call.request().toString());
            log.info("============================================================================");

            Response<String> response = call.execute();

            if (response.isSuccessful()) { // Http Status Code == 200~300
                CouponDetailVO couponDetailVO = CouponConverter.stringToCouponDetail(response.body());

                if (StringUtils.equals(couponDetailVO.getResultCode(), CouponConstants.ResultCode.SUCCESS_CODE)) { // Success
                    log.info("==> {}", couponDetailVO.toString());
                } else { // Error
                    log.error("Error - ResultCode: {}, ResultMsg: {}", couponDetailVO.getResultCode(), couponDetailVO.getResultMsg());
                }
            } else { // Http Status Code != 200~300
                log.error("Http Status Error: {}", response.code());
            }
        } catch (Exception e) {
            log.error(e.getCause() == null ? e.toString() : e.getCause().toString());
        }
    }

    /*
     * ISSUE : json
     *
     */
    public void couponRtJsonSend() {
        try {
            CouponIfService service = CouponBuilder.getInstance().getServiceInstance(SERVICE_MODE, HOST_TYPE, CouponIfService.class);


            Call<CouponRtJsonSendVO> call = service.couponRtJsonSend(E_ID, M_ID, G_ID, O_CNT, "", OMOBILE, RMOBILE, T_ID, TM, CM);

            log.info("=============================== Request Info ===============================");
            log.info(call.request().toString());
            log.info("============================================================================");

            Response<CouponRtJsonSendVO> response = call.execute();

            if (response.isSuccessful()) { // Http Status Code == 200~300
                CouponRtJsonSendVO couponRtJsonSendVO = response.body();
                log.info(couponRtJsonSendVO.toString());

                if ("[SUCCESS CODE]0".equals(couponRtJsonSendVO.getResultCode()) || "[SUCCESS CODE]1".equals(couponRtJsonSendVO.getResultCode())) { // Success
                    log.info("==> {}", couponRtJsonSendVO.toString());
                } else { // Error
                    log.error("Error - ResultCode: {}, ResultMsg: {}", couponRtJsonSendVO.getResultCode(), couponRtJsonSendVO.getResultMsg());
                }
            } else { // Http Status Code != 200~300
                log.error("Http Status Error: {}", response.code());
            }


        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * CHANGE EXCHANGE DAY
     */
    public void couponExchangeDays() {
        try {
            CouponIfService service = CouponBuilder.getInstance().getServiceInstance(SERVICE_MODE, HOST_TYPE, CouponIfService.class);


            Call<String> call = service.couponExchange(E_ID, T_ID, E_DAYS);

            log.info("=============================== Request Info ===============================");
            log.info(call.request().toString());
            log.info("============================================================================");

            Response<String> response = call.execute();

            if (response.isSuccessful()) { // Http Status Code == 200~300
                CouponExchangeVO couponExchangeVO = CouponConverter.stringToCouponExchange(response.body());

                if (StringUtils.equals(couponExchangeVO.getResultCode(), CouponConstants.ResultCode.SUCCESS_CODE)) { // Success
                    log.info("==> {}", couponExchangeVO.toString());

                } else { // Error
                    log.error("Error - ResultCode: {}, ResultMsg: {}", couponExchangeVO.getResultCode(), couponExchangeVO.getResultMsg());
                }
            } else { // Http Status Code != 200~300
                log.error("Http Status Error: {}", response.code());
            }
        } catch (Exception e) {
            log.error(e.getCause() == null ? e.toString() : e.getCause().toString());
        }
    }

}
