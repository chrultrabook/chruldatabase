use diesel::Queryable;

#[derive(Queryable)]
#[diesel(table_name = arch)]
pub struct Arch {
  id: u32,
  short: String,
  name: String
}
