pub mod entities;
pub mod enums;
mod reqs;

use rocket::{launch, routes};

#[launch]
fn start() -> _ {
    //TODO: init diesel

    rocket::build().mount("/", routes![
        reqs::get_devices_all,
        reqs::get_device_by_name,
        reqs::get_devices_by_arch,
        reqs::get_gen_all,
        reqs::get_gen_by_name
    ])
}
