package hmda.model.publication.reports

case class Disposition(
    dispositionName: String,
    count: Int,
    value: Int
) {
  def +(disp: Disposition): Disposition = {
    Disposition(dispositionName, count + disp.count, value + disp.value)
  }
}
