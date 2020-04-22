package hotel;

import hotel.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyviewViewHandler {


    @Autowired
    private MyviewRepository myviewRepository;


    //  예약 완료 resultEnded 이벤트 발생 시
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1(@Payload ResultEnded resultEnded) {
        try {
            if (resultEnded.isMe()) {
                // view 객체 생성
                Myview myview = new Myview();

                // view 객체에 이벤트의 Value 를 set 함
                myview.setRegId(resultEnded.getRegId());
                myview.setName(resultEnded.getName());
                myview.setUserid(resultEnded.getUserid());
                myview.setStatus(resultEnded.getStatus());
                //myview.setPhone(resultEnded.getPhone());
                //myview.setDate(resultEnded.getDate());
                // view 레파지 토리에 save
                myviewRepository.save(myview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  예약수정 : ResultChanged 이벤트 발생시
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_UPDATE_1(@Payload ResultChanged resultChanged) {
        try {
            if (resultChanged.isMe()) {
                // view 객체 생성
                Myview myview = new Myview();

                // view 객체에 이벤트의 Value 를 set 함
                myview.setRegId(resultChanged.getRegId());
                myview.setName(resultChanged.getName());
                myview.setUserid(resultChanged.getUserid());
                myview.setStatus(resultChanged.getStatus());
                // view 레파지 토리에 save
                myviewRepository.save(myview);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
   }
}