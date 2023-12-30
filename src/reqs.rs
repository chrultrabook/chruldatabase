use rocket::get;

#[get("/hi")]
pub fn hi() -> &'static str {
  "Hello, world!"
}
