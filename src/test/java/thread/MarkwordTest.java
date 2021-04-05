package thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class MarkwordTest {
    public static void main(String[] args) {
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        o.hashCode();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
