package cocurrent.java.containter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynContainer {
    ArrayList<String> strings = new ArrayList<>();
    List<String> stringList = Collections.synchronizedList(strings);


}
