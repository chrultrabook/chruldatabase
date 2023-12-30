use diesel::Queryable;

#[derive(Queryable)]
#[diesel(table_name = win_drivers)]
pub struct WinDrivers {
  id: u32,
  device_id: u32,
  arch_id: u32,
  name: String,
  download_link: u32
}