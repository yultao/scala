package tt.lab.spark.scala;

//import com.citi.kafkaesque.common.GenericMessage;
import com.citi.mirrorlake.common.GenericDataModel;
//import com.citi.mirrorlake.interop.common.XGenericDataModel;
//import com.citi.mirrorlake.kafkaesqueclient.MirrorlakeConsumer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang.SerializationException;
//import org.apache.kafka.common.serialization.Deserializer;
//import org.apache.thrift.TDeserializer;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocolFactory;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

/**
 * Created by ak52242 on 6/2/2017.
 */
public class GDMDeserializer implements Deserializer<GenericDataModel> {
//    private static final TProtocolFactory factory = new TBinaryProtocol.Factory();
    public void close() {
    	System.out.println("GDMDeserializer.close()");
    }
    public void configure(Map<String, ?> arg0, boolean arg1) {
    	System.out.println("GDMDeserializer.configure()");
    }

    public GenericDataModel deserialize(String arg0, byte[] gdmInBytes) {
    	System.out.println("GDMDeserializer.deserialize() "+ arg0+", "+ gdmInBytes.length);
    	return null;
//        try {
//            GenericMessage message = new GenericMessage();
//            message.setObjectBytes(gdmInBytes);
//            message.setObjectType("GDM");
//            GenericDataModel gdm = (GenericDataModel) MirrorlakeConsumer
//                    .deserialize(message);
//            return gdm;
//        } catch (Exception var5) {
//            throw new SerializationException(var5);
//        }
    }
}
