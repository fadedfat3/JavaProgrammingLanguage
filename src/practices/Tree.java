package practices;

import java.util.Iterator;
import java.util.List;

public interface Tree extends Iterator {
    int getDepth();
    List<?> previousOrder();
    List<?> inOrder();
    List<?> postOrder();
    void insert(Object o);
    void delete(Object o);
    Object search(Object o);


}
