use diesel::Queryable;
use crate::enums::os;

#[derive(Queryable)]
#[diesel(table_name = device_notes)]
pub struct DeviceNotes {
  id: u32,
  os: os,
  device_id: u32,
  note: String
}
