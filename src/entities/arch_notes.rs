use diesel::Queryable;
use crate::enums::os;

#[derive(Queryable)]
#[diesel(table_name = arch_notes)]
pub struct ArchNotes {
  id: u32,
  os: os,
  arch_id: u32,
  note: String,
  show_on_dev_note: bool
}