package thread;

import org.openjdk.jol.info.ClassLayout;

public class MarkwordHashCodeTest {
    public static void main(String[] args) {
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        o.hashCode();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
