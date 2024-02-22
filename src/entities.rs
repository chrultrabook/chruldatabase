use crate::enums::os;
use diesel::Queryable;

#[derive(Queryable)]
#[diesel(table_name = brand)]
pub struct Brand {
    id: u32,
    name: String,
}

#[derive(Queryable)]
#[diesel(table_name = device)]
struct Device {
    id: u32,
    name: String,
    generation_id: u32,
    brand_id: u32,
    stock_kernel_partsize: u64,
}

#[derive(Queryable)]
#[diesel(table_name = device_notes)]
pub struct DeviceNotes {
    id: u32,
    os: os,
    device_id: u32,
    note: String,
}

#[derive(Queryable)]
#[diesel(table_name = generation)]
pub struct Gen {
    id: u32,
    short: String,
    name: String,
}

#[derive(Queryable)]
#[diesel(table_name = generation_notes)]
pub struct GenNotes {
    id: u32,
    os: os,
    generation_id: u32,
    note: String,
    show_on_dev_note: bool,
}

#[derive(Queryable)]
#[diesel(table_name = win_drivers)]
pub struct WinDrivers {
    id: u32,
    device_id: u32,
    generation_id: u32,
    name: String,
    download_link: u32,
}
