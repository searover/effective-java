package net.mindview.holding;

import java.util.Arrays;
import java.util.List;

/**
 * @author searover
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snows = Arrays.asList(new Crusty(), new Slush(), new Powder());
        System.out.println(snows);
        List<Snow> snows1 = Arrays.asList(new Light(), new Heavy());
        System.out.println(snows1);
    }
}

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}
