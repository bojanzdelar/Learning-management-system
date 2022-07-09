export function formatDateTime(dateTime: Date) {
  const [date, time] = dateTime.toString().split('T');
  return `${date}, ${time}`;
}
