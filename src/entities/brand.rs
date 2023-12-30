use diesel::Queryable;

#[derive(Queryable)]
#[diesel(table_name = brand)]
pub struct Brand {
  id: u32,
  name: String
}
