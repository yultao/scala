package tt.lab.spark.ml;

import java.util.Iterator;

import com.citi.mirrorlake.common.GenericDataModel;
import com.citi.mirrorlake.common.MLDataIterator;
import com.citi.mirrorlake.common.exception.MirrorlakeException;
import com.citi.mirrorlake.rmiclient.MirrorlakeClientFactory;
import com.citi.mirrorlake.rmiclient.ReadOnlyMirrorlakeClient;

public class DataSource {
	public static void main(String[] args) {
		ReadOnlyMirrorlakeClient mlClient = MirrorlakeClientFactory.getReadOnlyMirrorlakeClient("UAT");
		String entity = "Credit.Risk.CVA";
		String keyFrom = "20170331.20170330.                PECD.NY.  ALL. Mars.            BASE_18T.           CVA.   GRAVITY.            CVA.        NETID.                         CBNA-02-GTR-0-4";
		String keyTo = keyFrom;
		try {
			MLDataIterator it = mlClient.getByPrimaryKey(entity,keyFrom,keyTo);
			Iterator<GenericDataModel> iterator = it.iterator();
			while(iterator.hasNext()){
				GenericDataModel gdm = iterator.next();
				System.out.println(gdm);
			}
		} catch (MirrorlakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
