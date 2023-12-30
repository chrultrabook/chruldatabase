mod reqs;
pub mod entities;
pub mod enums;

use rocket::{launch, routes};

#[launch]
fn start() -> _ {
    rocket::build().mount("/", routes![reqs::hi])
}
