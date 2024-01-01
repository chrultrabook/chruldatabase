pub mod entities;
pub mod enums;
mod reqs;

use rocket::{launch, routes};

#[launch]
fn start() -> _ {
    rocket::build().mount("/", routes![reqs::hi])
}
