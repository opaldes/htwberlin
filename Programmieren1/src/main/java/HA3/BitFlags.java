package HA3;

public class BitFlags {
    private int status;

    BitFlags(int initStatus) {
        this.status = initStatus;
    }

    public void printFlags() {
        System.out.println(Integer.toBinaryString(this.status));
    }

    // always set the bit at index i to 1
    public void switchOn(int index) {
            // create a bitmask 0...01 and shift 1 to the index i
            // e.g.: 0000001 with index 1 will become 0000010
            int bitMask = 0b1 << index; // 0b1 is a binary literal
            /*   OR
             *   0 0 -> 0
             *   0 1 -> 1
             *   1 0 -> 1
             *   1 1 -> 1
             */
            this.status = this.status | bitMask; // binary operator for bitwise OR (OR operation for each bit (binary place) of both integers)
    }

    // always set the bit at index i to 0
    public void switchOff(int index) {
            int bitMask = 0b1 << index;
            /*   XOR
             *   0 0 -> 0
             *   0 1 -> 1
             *   1 0 -> 1
             *   1 1 -> 0
             */
            int bitDiff = this.status ^ bitMask; // binary operator for bitwise XOR
            /*   AND
             *   0 0 -> 0
             *   0 1 -> 0
             *   1 0 -> 0
             *   1 1 -> 1
             */
            this.status = this.status & bitDiff; // binary operator for bitwise AND
    }

    // always invert the bit at index i
    public void swap(int index) {
        int bitMask = 0b1 << index;
        this.status = this.status ^ bitMask;
    }

    // check if the bit at index i is 1 and return a boolean result
    public boolean isSet(int index) {
        int bitMask = 0b1 << index;
        boolean bitStatus = (this.status & bitMask) > 0;

        String bitMsg = bitStatus ? "1 (set)" : "0 (unset)";
        System.out.println("Bit at index " + index + " is " + bitMsg);

        return bitStatus;
    }

    public static void main(String[] args) {
        BitFlags bFlags = new BitFlags(Integer.MAX_VALUE);

        bFlags.printFlags();

        bFlags.switchOff(4);
        bFlags.printFlags();
        bFlags.switchOff(4);
        bFlags.printFlags();

        bFlags.switchOn(4);
        bFlags.printFlags();
        bFlags.switchOn(4);
        bFlags.printFlags();

        bFlags.isSet(4);
        bFlags.swap(4);
        bFlags.printFlags();
        bFlags.isSet(4);
        bFlags.swap(4);
        bFlags.printFlags();
        bFlags.isSet(4);
    }
}
