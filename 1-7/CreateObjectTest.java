class CreateObjectTest{
  private var sum = 0
  def checksum(): Int = ~(sum & 0xFF) + 1
  def add(b: Byte){sum += b}
}
