use rocket::get;

/// Get all devices
#[get("/device/all")]
pub fn get_devices_all() {}

/// Get all devices for a cpu generation
#[get("/device/gen/<gen>")]
pub fn get_devices_by_arch(gen: String) {}

/// Get a device by board name
#[get("/device/name/<name>")]
pub fn get_device_by_name(name: String) {}

/// Get all cpu generations
#[get("/gen/all")]
pub fn get_gen_all() {}

/// Get cpu generation and related notes by shortname
#[get("/gen/name/<gen>")]
pub fn get_gen_by_name(gen: String) {}

//TODO: Notes separate?
//TODO: Do we need a `get_all()`?
