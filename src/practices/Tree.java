package practices;

import java.util.Iterator;
import java.util.List;

public interface Tree extends Iterator {
    int getDepth();
    List<?> previousOrder();
    List<?> inOrder();
    List<?> postOrder();
    boolean insert(Object o);
    boolean delete(Object o);
    Object search(Object o);


}
