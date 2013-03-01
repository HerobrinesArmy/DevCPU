package devcpu.emulation;

public class AWTKeyMapping extends KeyMapping
{
  public AWTKeyMapping()
  {
  	map(32, 32);
  	
    map(38, 128);
    map(40, 129);
    map(37, 130);
    map(39, 131);

    map(10, 17);
    map(8, 16);
    map(155, 18);
    map(127, 19);

    map(16, 144);
    map(17, 145);
    map(18, 145);
    map(65406, 145);

    map(49, 49);
    map(50, 50);
    map(51, 51);
    map(52, 52);
    map(53, 53);
    map(54, 54);
    map(55, 55);
    map(56, 56);
    map(57, 57);
    map(48, 48);

    map(81, 113);
    map(87, 119);
    map(69, 101);
    map(82, 114);
    map(84, 116);
    map(89, 121);
    map(85, 117);
    map(73, 105);
    map(79, 111);
    map(80, 112);

    map(65, 97);
    map(83, 115);
    map(68, 100);
    map(70, 102);
    map(71, 103);
    map(72, 104);
    map(74, 106);
    map(75, 107);
    map(76, 108);

    map(90, 122);
    map(88, 120);
    map(67, 99);
    map(86, 118);
    map(66, 98);
    map(78, 110);
    map(77, 109);
  }
}